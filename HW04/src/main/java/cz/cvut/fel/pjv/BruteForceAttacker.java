package cz.cvut.fel.pjv;

public class BruteForceAttacker extends Thief {
    
    /**
     * Stores array of character used in password
     */
    private char[] characters;
    
    /**
     * Size of password
     */
    private int size;
    
    @Override
    public void breakPassword(int sizeOfPassword) {
        // write your code 
        this.characters = super.getCharacters();
        this.size = sizeOfPassword;
        
        //Get first allowed password
        int[] first = new int[this.size];
        for (int i = 0; i < this.size; i++)
        {
            first[i] = 0;
        }
        
        //Get last allowed password
        int[] last = new int[this.size];
        for (int i = 0; i < this.size; i++)
        {
            last[i] = this.characters.length - 1;
        }
        
        this.tryPassword(first, last);
        
    }
    /**
     * Recursive function to try password
     * @param password Password to check
     * @param lastAllowed Last password allowed to check
     * @return <code>TRUE</code> if password has been revealed, <code>FALSE</code> if not.
     */
    private boolean tryPassword(int[] password, int[] lastAllowed)
    {
        boolean reti = false;
        char[] pswd = new char[this.size];
        for (int i = 0; i < this.size; i++)
        {
            pswd[i] = this.characters[password[i]];
        }
        if (super.tryOpen(pswd) == false)
        {
            if (password != lastAllowed)
            {
                reti = this.tryPassword(this.getNextPassword(password), lastAllowed);
            }
        }
        else
        {
            reti = true;
        }
        return reti;
    }
    
    /**
     * Function to generate next password
     * @param password Password to generate successor of
     * @return Next password
     */
    private int[] getNextPassword(int[] password)
    {
        int reti[] = new int[this.size];
        boolean overflow = false;
        int char_len = this.characters.length;
        for (int i = this.size - 1; i >= 0; i--)
        {
            int value = password[i];
            value++;
            if (overflow)
            {
                value ++;
                overflow = false;
            }
            if (value >= char_len)
            {
                value = value % this.size;
                overflow = true;
            }
            reti[i] = value;
        }
        
        return reti;
    }
    
}
