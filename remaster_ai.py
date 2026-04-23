import subprocess
import os
from pathlib import Path

def remaster_images():
    input_dir = Path(r"C:\Users\Jack\Downloads\papercraftlin")
    output_dir = input_dir / "remastered_ai"
    script_path = Path(r"C:\Users\Jack\.openclaw\workspace\skills\nano-banana-pro\scripts\generate_image.py")
    
    if not output_dir.exists():
        output_dir.mkdir(parents=True)
        
    images = [f for f in input_dir.iterdir() if f.suffix.lower() in ('.png', '.jpg', '.jpeg')]
    
    prompt = (
        "Remaster and upscale this Minecraft papercraft template. "
        "Eliminate all pixelation and compression artifacts, replacing them with sharp, "
        "clean vector-like lines and high-definition textures. "
        "Ensure every detail, especially the folding and cutting lines, is perfectly "
        "preserved and easily visible. The output should look like a professional, "
        "high-resolution digital master file. 4K resolution, white background."
    )
    
    for img_path in images:
        output_path = output_dir / f"{img_path.stem}_remastered.png"
        print(f"Remastering {img_path.name} -> {output_path.name}")
        
        cmd = [
            "python", str(script_path),
            "--prompt", prompt,
            "--filename", str(output_path),
            "--input-image", str(img_path),
            "--resolution", "4K"
        ]
        
        try:
            result = subprocess.run(cmd, capture_output=True, text=True, check=True)
            print(result.stdout)
        except subprocess.CalledProcessError as e:
            print(f"Error processing {img_path.name}:")
            print(e.stderr)
            print(e.stdout)

if __name__ == "__main__":
    remaster_images()
