package com.zyd.justtest;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhengyanda on 2018/6/19.
 */
public class MainActivityTest {

    @Test
    public void formatBase64() throws Exception {
        String s2 = "iVBORw0KGgoAAAANSUhEUgAAABEAAAAQCAYAAADwMZRfAAAB80lEQVQ4T2NkwAMc5AQmMPxnuHDg8YcF+NQx4pJ0kBNYEOvmpwKSX7xr020GBoYHvNzcyZ8/f4078OTDAWR9WA2BGZDkE2QNUnz36aMjBZO79FY39LwIayz5tfn6E128hjjICTTEuvm5wAyAKf745cuF9sWzGDzMbT42zp+2ANmLjA5yAgUMDAzyDIwMBiANsa5+rOgGwAw6cO7UQX5uXsYJaxexP3rxfDvDf4aLBx5/2MDopyHxSZCL7SXDfwbOh+8+S1vrGFwwUdf5KMjL9x/ZyWduXuHccvyQOUj+65e30u8/f/j44uM3sZ133/Az1rrqP9BXEJfHF/q45Laeu3Vx/tkHBoyZ5ipXnPWUtCkyJNFY4YK3kZo+MYb8/v331pl7z/+IC/P9/fvvP+epWw/F3n/+4c9IiiEg58c5myhLi4n85OLgEAZZXD5v/UmSDDl5+8lRDzNdMSFerm+c7Bz/f/z+9bN+0da3JBkCsvnN569HPnz5+QfEPnX/6e93X7+HkWwIctjtv3J/4dTjtxOoY0iApsQ1C2WZlyAbpIR4RJgYGcFOZWVikmBmYZYAsf/9//fl1++/d0DsP//+cbx4//UFiH32/tO3q68+DwFnQAcJAQUGFgYFsFOZGBxwRvd/hgcMIAwCLAwXDjz48AHEBAD2xeD0sI6Q7QAAAABJRU5ErkJggg==";
        String s1 = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABEAAAAQCAYAAADwMZRfAAAB80lEQVQ4T2NkwAMc5AQmMPxnuHDg8YcF+NQx4pJ0kBNYEOvmpwKSX7xr020GBoYHvNzcyZ8/f4078OTDAWR9WA2BGZDkE2QNUnz36aMjBZO79FY39LwIayz5tfn6E128hjjICTTEuvm5wAyAKf745cuF9sWzGDzMbT42zp+2ANmLjA5yAgUMDAzyDIwMBiANsa5+rOgGwAw6cO7UQX5uXsYJaxexP3rxfDvDf4aLBx5/2MDopyHxSZCL7SXDfwbOh+8+S1vrGFwwUdf5KMjL9x/ZyWduXuHccvyQOUj+65e30u8/f/j44uM3sZ133/Az1rrqP9BXEJfHF/q45Laeu3Vx/tkHBoyZ5ipXnPWUtCkyJNFY4YK3kZo+MYb8/v331pl7z/+IC/P9/fvvP+epWw/F3n/+4c9IiiEg58c5myhLi4n85OLgEAZZXD5v/UmSDDl5+8lRDzNdMSFerm+c7Bz/f/z+9bN+0da3JBkCsvnN569HPnz5+QfEPnX/6e93X7+HkWwIctjtv3J/4dTjtxOoY0iApsQ1C2WZlyAbpIR4RJgYGcFOZWVikmBmYZYAsf/9//fl1++/d0DsP//+cbx4//UFiH32/tO3q68+DwFnQAcJAQUGFgYFsFOZGBxwRvd/hgcMIAwCLAwXDjz48AHEBAD2xeD0sI6Q7QAAAABJRU5ErkJggg==";
        System.out.println(formatBase64(s1).equals(s2));
        System.out.println(formatBase64(s2).equals(s2));
    }

    @Test
    public void fromMap() throws Exception {
    }

    public String formatBase64(String base64) {
        if (base64.startsWith("data:")) {
            int index = base64.indexOf("base64,") + 7;
            base64 = base64.substring(index);
        }
        return base64;
    }

}