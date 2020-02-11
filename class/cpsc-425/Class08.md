---
date: 30-Jan-2020
---

# Lecture 8 - Edge Detection

## Recap

* When computing a 2D derivative, compute derivatives in the X direction and the Y direction separately.

## Edge Detection

* **Edge detection** -> identify sudden changes in image intensity
  * Invariant in brightness
* An edge is a location with a high value of the derivative
* Derivative computation is **sensitive to noise**:

![Effect of noise on derivative](figures/08-derivative-noise.png)

* Applying a Gaussian filter prior to the derivative computation can minimize this problem:

![Derivative after gaussian filter](figures/08-derivative-gaussian.png)

### Image Gradient

* The gradient of the image is the vector $[I_x, I_y]$ where $I_x$ and $I_y$ are the partial derivatives of the image
* The gradient points in the direction of most rapid **increase in intensity**

### Edge Detector

* Sobel detector
  * Uses central differencing to compute gradient
  * Use threshold to obtain edges

* Two general approaches to edge detector
  * Significant local extrema of **first** derivative
  * Zero crossings of **second** derivative
