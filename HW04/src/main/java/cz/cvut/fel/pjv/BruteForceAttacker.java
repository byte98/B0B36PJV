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
    
    /**
     * Space to save actually tried password
     */
    private int[] int_buffer;
    
    /**
     * Space to save actually tried password as characters
     */
    private char[] char_buffer;
    
    /**
     * Last combination of given characters
     */
    private int[] last;
    
    private boolean success;
    
    private int combinations;
    private int try_c;
    
    @Override
    public void breakPassword(int sizeOfPassword)
    {
        
        this.characters = super.getCharacters();
        this.size = sizeOfPassword;
        this.int_buffer = new int[this.size];
        this.char_buffer = new char[this.size];
        this.last = new int[this.size];
        this.success = false;
        this.combinations = (int)Math.ceil(Math.pow(this.characters.length, this.size));
        
        //Set maximal password
        for (int i = 0; i < this.size; i++)
        {
            this.last[i] = this.char_buffer.length - 1;
        }
        
        //Set first password
        for (int i = 0; i < this.size; i++)
        {
            this.int_buffer[i] = 0;
        }
        //System.out.println(this.combinations);
        this.tryPassword();

    }
    
    /**
     * Recursive function to try to break password
     */
    private void tryPassword()
    {   
        //Transforms int buffer to char buffer
        for (int i = 0; i < this.size; i++)
        {
            this.char_buffer[i] = this.characters[this.int_buffer[i]];
        }
                
        this.success = super.tryOpen(this.char_buffer);
        if (this.success == false)
        {
            //Generate next password
            boolean overflow = false;
            for (int i = this.size - 1;i >= 0; i--)
            {
                if (i == this.size - 1 || overflow)
                {
                    this.int_buffer[i]++;   
                    overflow = false;
                }
                if (this.int_buffer[i] >= this.characters.length)
                {
                    this.int_buffer[i] = 0;
                    overflow = true;
                }
            }
            this.tryPassword();
        }
    }
}
