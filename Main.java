/*Huffman code encoder
*        Copyright (C) 2015  Amir Hosein Fadaei
*
*       This program is free software: you can redistribute it and/or modify
*        it under the terms of the GNU General Public License as published by
*        the Free Software Foundation, either version 3 of the License, or
*        (at your option) any later version.
*
*        This program is distributed in the hope that it will be useful,
*        but WITHOUT ANY WARRANTY; without even the implied warranty of
*        MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
*        GNU General Public License for more details.
*
*        You should have received a copy of the GNU General Public License
*        along with this program.  If not, see <http://www.gnu.org/licenses/>.*/

import Tree.Node;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hi! Please enter symbols:affluence like \"a:23\"");
        System.out.println(": symbol is invalid");
        System.out.println("only one character is available before :");
        System.out.println("enter \"end\" to end!");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map map = new HashMap();
        String in;
        while(true){
            try {
                in = br.readLine();
                if(in.equals("end"))
                    break;
                String[] parts = in.split(":");
                map.put(parts[0],parts[1]);
            } catch (Exception e) {
                System.out.println("Error, Wrong Input... :|");
                e.printStackTrace();
            }
        }
        Node n = Huffman.build(map);
        Huffman.compute(n);
    }
}
