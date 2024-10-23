# rubix
A Rubik’s Cube solver that provides step-by-step instructions based on a cube's face configuration using C++/Java.

# group members
Muhammad Saad Hussain
Sohaib Amir Bukhari
Abdullah Farooq

## Features
- Capture cube face configuration using the camera
- Input the colors manually
- Display moves (`R`, `R'`, `U`, etc.) to solve the cube manually

## Setup
### Prerequisites
- C++/Java compiler
- OpenCV library (for image processing)

### Build Instructions
```bash
# Clone the repository
git clone https://github.com/Abdullah-Farooq-5/rubix.git

# Navigate to the src directory
cd src/

# Build the project (for C++)
g++ main.cpp -o RubiksCubeSolver

# Run the project
./RubiksCubeSolver
