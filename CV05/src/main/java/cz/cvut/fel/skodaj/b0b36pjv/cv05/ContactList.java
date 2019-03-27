/*
 * Copyright 2019 Jiří Škoda <skodaji4@fel.cvut.cz>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cz.cvut.fel.skodaj.b0b36pjv.cv05;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author Jiří Škoda <skodaji4@fel.cvut.cz>
 */
public class ContactList 
{
    private ArrayList<Contact> contacts;
    private int count = 0;

    public int size()
    {
        return this.count;
    }

    public boolean isEmpty()
    {
        return (this.count == 0);
    }

    public boolean contains(Object o)
    {
        boolean reti = false;
        for (int i = 0; i < this.count; i++)
        {
            if (o == this.contacts.get(i))
            {
                reti = true;
                break;
            }
        }
        
        return reti;
    }


    public Object[] toArray()
    {
        Contact[] reti = new Contact[this.count];
        for (int i = 0; i < this.count; i++)
        {
            reti[i] = this.contacts.get(i);
        }
        return reti;
    }

    public Object[] toArray(Object[] a)
    {
        for (int i = 0; i < (a.length < this.count ? a.length : this.count); i++)
        {
            a[i] = this.contacts.get(i);
        }
        return a;
    }


    public boolean add(Object e)
    {
        this.contacts.add((Contact) e);
        this.count++;
        return true;
    }


    public boolean remove(Object o)
    {
        boolean reti = false;
        if(this.contacts.contains(o))
        {
            ArrayList<Contact> contacts_new = null;
            for (int i = 0; i < this.count - 1; i++)
            {
                if (this.contacts.get(i) != (Contact) o)
                {
                    contacts_new.add(this.contacts.get(i));
                }
            }
            this.contacts = contacts_new;
        }
        
        return reti;
    }


    @Override
    public String toString() {
        String reti = "";
        for (int i = 0; i < this.count;  i++)
        {
            reti += this.contacts.get(i).toString();
            if (i < (this.count - 2))
            {
                reti +="; ";
            }
        }
        return reti;
    }
    
}
