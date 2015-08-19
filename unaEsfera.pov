#include "colors.inc" 

background { 
  color White
}
sphere { 
  <-0, 0, 4>, 
  2.5
  pigment { 
    color Red 
  } 
}
light_source { 
  <-10, 10, -10> 
  color White
}  

camera {
  location <0, 0, -8>
  look_at  <0, 0, 4>
}
