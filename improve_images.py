import cv2
import os
import numpy as np

def improve_image(input_path, output_path):
    print(f"Processing {input_path}...")
    # Load image
    img = cv2.imread(input_path)
    if img is None:
        print(f"Error loading {input_path}")
        return

    # 1. Upscale 4x using Lanczos interpolation (smoother than cubic)
    height, width = img.shape[:2]
    new_width = width * 4
    new_height = height * 4
    
    # Using INTER_LANCZOS4 for high quality upscaling
    img_upscaled = cv2.resize(img, (new_width, new_height), interpolation=cv2.INTER_LANCZOS4)

    # 2. Apply Bilateral Filter to smooth surfaces but keep edges sharp
    # This helps with "no pixels" look while keeping lines
    # d=9, sigmaColor=75, sigmaSpace=75 are standard values
    img_smoothed = cv2.bilateralFilter(img_upscaled, 9, 40, 40)

    # 3. Slight sharpening to recover some detail in the lines
    kernel = np.array([[-1,-1,-1], [-1,9,-1], [-1,-1,-1]]) * 0.1
    # We don't want too much sharpening or pixels will reappear
    # Just a subtle touch
    img_final = cv2.filter2D(img_smoothed, -1, kernel)
    
    # Or maybe just the smoothed version is better
    # Let's use a subtle unsharp mask
    gaussian = cv2.GaussianBlur(img_smoothed, (0, 0), 2.0)
    img_final = cv2.addWeighted(img_smoothed, 1.5, gaussian, -0.5, 0)

    # Save
    cv2.imwrite(output_path, img_final, [cv2.IMWRITE_JPEG_QUALITY, 95])

def main():
    input_dir = r"C:\Users\Jack\Downloads\papercraftlin"
    output_dir = os.path.join(input_dir, "improved")
    
    if not os.path.exists(output_dir):
        os.makedirs(output_dir)
        
    files = [f for f in os.listdir(input_dir) if f.lower().endswith(('.png', '.jpg', '.jpeg'))]
    
    for f in files:
        input_path = os.path.join(input_dir, f)
        output_name = os.path.splitext(f)[0] + "_improved.jpg"
        output_path = os.path.join(output_dir, output_name)
        improve_image(input_path, output_path)

if __name__ == "__main__":
    main()
