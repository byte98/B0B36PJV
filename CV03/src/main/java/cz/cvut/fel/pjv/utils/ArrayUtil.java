/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.fel.pjv.utils;

/**
 *
 * @author Jiří Škoda <skodaji4@fel.cvut.cz>
 */
public final class ArrayUtil
{
    private ArrayUtil(){}
    
    public static void sort(Comparable[] array)
    {
        for (int i = 0; i < array.length - 1; i++)
        {
            for (int j = 0; j < array.length - i - 1; j++)
            {
                if (array[j].compareTo(array[j+1]) > 0)
                {
                    Comparable tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
    }
}
