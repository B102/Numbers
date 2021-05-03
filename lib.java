package numbers;

import java.util.Arrays;

public class lib {
        
    double[][] scaAdd(double scalar, double[][] m){
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m[0].length; j++){
                m[i][j] += scalar;
            }
        }
        return m;
    }
    
    double[][] matAdd(double[][] m1, double[][] m2){
        for(int i = 0; i < m1.length; i++){
            for(int j = 0; j < m1[0].length; j++){
                m2[i][j] += m1[i][j];
            }
        }
        return m2;
    }
    
    double[][] dotMul(double[][] m1, double[][] m2) {
        double[][] cache = new double[m1.length][m2[0].length];
        for(int i = 0; i < cache.length; i++)
        {
            for(int j = 0; j < cache[0].length; j++)
            {
                double sum = 0;
                for(int k = 0; k < m1[0].length; k++)
                {
                    sum += m1[i][k] * m2[k][j];
                }
                cache[i][j] = sum;
            }
        }
        return cache;
    }
    
    double[][] valMul(double[][] m1, double[][] m2) {
        for(int i = 0; i < m1.length; i++)
        {
            for(int j = 0; j < m1[0].length; j++)
            {
                m2[i][j] *= m1[i][j];
            }
        }
        return m2;
    }
    
    double[][] scaMul(double a, double[][] m) {
        for(int i = 0; i < m.length; i++)
        {
            for(int j = 0; j < m[0].length; j++)
            {
                m[i][j] *= a;
            }
        }
        return m;
    }
    
    double[][] T(double[][] m){
        int i, j;
        double[][] cache = new double[m[0].length][m.length];
        for (i = 0; i < m[0].length; i++){
            for (j = 0; j < m.length; j++){
                cache[i][j] = m[j][i];
            }
        }
        return cache;
    }
    
    void print2D(double[][] m){
        for (double[] row : m){
            System.out.println(Arrays.toString(row));
        }
    }
}
