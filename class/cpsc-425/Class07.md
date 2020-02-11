---
date: 28-Jan-2020
---

# Lecture 7 - Template Matching and Scaled Representations

## How can we find instances of a pattern in an image?

* **Template matching** -> Use the pattern as the template
  * Turn the pattern into a filter then perform correlation
  * Applying a filter -> computing a dot product, so higher values = more similar parts
  * Pattern may produce higher values just because it is a brighter region
  * Normalize using the `cos` formula
* **Correlation map** -> Similarity to a specific pattern at all parts of the picture
  * Have a threshold -> Higher than this threshold is considered a detection
* Main problem -> Sensitive to changes in 2D scale

## Scaled Representations

* **Scaled representation** -> Make template matching robust to changes in 2D scale
  * Build a scaled representation; the Gaussian image pyramid
  * Shrink down the images, check the template at all scales

* How to shrink images
  * Gaussian blur the original picture
  * Take out the even columns and rows
  * Generally scaling down by `0.5` requires a sigma of `1`

## Local Feature Detection

* Objects look different from different angles, and may be blocked/obscured by other objets
* Template matching fails to find objects in images if it is obscured or at a different angle
* **Local feature detection** attempts to look for parts of objects
  * Obvious local features include *edges* and *corners*

We can use derivatives to find the edges in an image.

* Filter for derivative very simple -> `[-1, 1]`
