#include <stdio.h>
#include <math.h>

int main() {
float U, x, y;

for (x = 1; x <= 3; x = x + 1.3) {
    for (y = 0.3; y <= 0.5; y = y + 0.1) {
        
        if ((x / y) < 1) {
            float term1 = log10(x + (x / y));
            float term2 = (pow(y, 1.0/3.0) * (4 * pow(x, 2) + 1)) / (3 *pow(cos(fabs(x - y)), 2));
            
            if (term1 > term2) {
                U = term1;
            } else {
                U = term2;
            }
        } else {
            U = (tan(x * y) + 2.6)/ sqrt(sin(x));
        }

        printf("x = %.2f, y = %.2f, U= %.4f\n", x, y, U);
    }
}

return 0;
}
