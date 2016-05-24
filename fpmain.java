/*
You are so excited about the 2016 Code Jam World Finals that you just moved to New York.
You have brought along J different jackets (numbered 1 through J), P different pairs of pants (numbered 1 through P), and S different shirts (numbered 1 through S).
You have at least as many shirts as pairs of pants, and at least as many pairs of pants as jackets. (J ≤ P ≤ S.)

Every day, you will pick one jacket, one pair of pants, and one shirt to wear as an outfit.
You wash all of your garments every night so all of your garments are available to use each day.

In New York, the Fashion Police officers are always watching and keeping track of what everyone wears every day.
If they find out that you have worn the exact same outfit twice, you will immediately be taken to the Fashion Jail on 5th Avenue for a mandatory makeover;
you definitely want to avoid that! You will also immediately be taken to Fashion Jail if they find out that you have worn the same two-garment combination
more than K times in total. A combination consists of a particular jacket worn with a particular pair of pants, a particular jacket worn with a particular shirt,
or a particular pair of pants worn with a particular shirt. For example, in the set of outfits (jacket 1, pants 2, shirt 3) and (jacket 1, pants 1, shirt 3),
the combination (jacket 1, shirt 3) appears twice, whereas the combination (pants 1, shirt 3) only appears once.

You will wear one outfit per day. Can you figure out the largest possible number of days you can avoid being taken to Fashion Jail and produce a list
of outfits to use each day?

Input

The first line of the input gives the number of test cases, T. T test cases follow; each consists of one line with four integers J, P, S, and K.

Output

For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is an integer: the maximum number
of days you will be able to avoid being taken to Fashion Jail. Then output y more lines, each of which consists of three integers: the numbers of the
jacket, pants, and shirt (in that order) for one day's outfit. The list of outfits can be in any order, but the outfits must not cause you to go to
Fashion Jail as described in the statement above.

If multiple answers are possible, you may output any of them.

Limits

1 ≤ T ≤ 100.
1 ≤ J ≤ P ≤ S.
1 ≤ K ≤ 10.
Small dataset

S ≤ 3.
Large dataset

S ≤ 10.
Sample


Input

Output

4
1 1 1 10
1 2 3 2
1 1 3 2
1 2 3 1

Case #1: 1
1 1 1
Case #2: 4
1 1 2
1 2 3
1 2 1
1 1 1
Case #3: 2
1 1 2
1 1 1
Case #4: 2
1 1 3
1 2 1

The sample output displays one set of answers to the sample cases. Other answers may be possible.

In Case #1, even though the Fashion Police officers have set a lenient K value of 10, there is only one possible outfit that you can form,
so you can only avoid Fashion Jail for one day.

In Case #2, adding any other outfit would cause you to go to Fashion Jail:

Adding 1 1 3 would use the combination (jacket 1, pants 1) more than 2 times.
Adding 1 2 2 would use the combination (jacket 1, pants 2) more than 2 times.
In this case, any set of 5 outfits would include at least one fashion violation.

Note that the numbers of the jacket, pants, and shirt within an individual outfit do not have to be in nondecreasing order in the same way that J, P, and S do.

In Case #3, you have only one jacket + pants combination which you must keep reusing, so no matter which shirts you wear, you cannot form more than K = 2 different outfits.

In Case #4, another possible maximally large set of outfits is:
1 2 2
1 1 1


*/


import javax.swing.*;
import javax.swing.WindowConstants;
import java.awt.*;
import java.util.*;
import java.io.*;

public class fpmain
{
    public static void main(String args[]) throws Exception
    {


        JFrame myFrame = new JFrame("Fashion Police");
        myFrame.setSize(720,480);
        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Scanner input = new Scanner(new File("C-small-practice.in"));

        // INTRO TEXT AND NUMBER OF CASES/PEOPLE
        System.out.println(" ");
        System.out.println("Please enter the number of test cases you'd like to take a look at: ");

        int numCases = input.nextInt();

        // RECEIVING OUTFIT INFO PER PERSON
        int [][] cases = new int [numCases][4];
        for (int n = 0; n < numCases; n++)
        {
            System.out.println("Please enter the number of jackets, pants, and shirts for person " + (n+1) + ", followed by the number of maximum fashion faux paus allowed: ");
            cases[n][0] = input.nextInt();  // X
            cases[n][1] = input.nextInt();  // Y
            cases[n][2] = input.nextInt();  // Z
            cases[n][3] = input.nextInt();  // K
        }

        // CREATING LABELS AND PANELS FOR EACH PERSON/CASE

        JPanel mainpanel = new JPanel();
        JScrollPane scrPane = new JScrollPane(mainpanel);

        JPanel[] casepanels = new JPanel [numCases];
        JPanel[] setpanels = new JPanel[numCases];
        JPanel[] lastedpanels = new JPanel [numCases];
        JPanel[] outfitpanels = new JPanel [numCases];
        for (int numEmp = 0; numEmp < numCases; numEmp++ )
        {

            casepanels[numEmp] = new JPanel();
            casepanels[numEmp].setLayout(new GridLayout(0,1,0,0));

            setpanels[numEmp] = new JPanel();
            lastedpanels[numEmp] = new JPanel();
            outfitpanels[numEmp] = new JPanel();

            casepanels[numEmp].add(setpanels[numEmp]);
            casepanels[numEmp].add(lastedpanels[numEmp]);
            casepanels[numEmp].add(outfitpanels[numEmp]);
            casepanels[numEmp].setBorder(BorderFactory.createTitledBorder("Visitor " + (numEmp+1)));
            outfitpanels[numEmp].setLayout(new FlowLayout(FlowLayout.LEFT));
            setpanels[numEmp].setLayout(new FlowLayout(FlowLayout.LEFT));

            JLabel curset = new JLabel("  " + cases[numEmp][0] + " Jackets, " + cases[numEmp][1] + " Pants, " + cases[numEmp][2] + " Shirts, and " + cases[numEmp][3] + " Maximum Fashion Faux Paus" );
            setpanels[numEmp].add(curset);
        }

        for (int numEmp = 0; numEmp < numCases; numEmp++ )
        {
            mainpanel.add(casepanels[numEmp]);
        }
        myFrame.add(scrPane);
        mainpanel.setLayout(new GridLayout(0, 1,0,0));

        scrPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // use case index operator for overloading of array parameter recursion



        for (int icount = 0; icount < numCases; icount++)
        {
            System.out.printf("Case #%d: ", icount + 1);

            if ((cases[icount][3]) >= (cases[icount][2]))
            {
                System.out.println((cases[icount][0]) * (cases[icount][1]) * (cases[icount][2]));
                casepanels[icount].add ( new JLabel( " Lasted (" + ((cases[icount][0]) * (cases[icount][1]) * (cases[icount][2])) + ") Days With This Set of Clothes"));
                for (int i = 0; i < (cases[icount][0]); i++)
                    for (int j = 0; j < (cases[icount][1]); j++)
                        for (int k = 0; k < (cases[icount][2]); k++)
                        {
                            System.out.println((i + 1) + " " + (j + 1) + " " + (k + 1));
                            outfitpanels[icount].add( new JLabel( " |" + ((i + 1) + " " + (j + 1) + " " + (k + 1)) + "| " ) );
                        }
            }
            else if ((cases[icount][3]) >= (cases[icount][1]))
            {
                System.out.println((cases[icount][0]) * (cases[icount][1]) * (cases[icount][3]));
                casepanels[icount].add ( new JLabel( " Lasted (" + ((cases[icount][0]) * (cases[icount][1]) * (cases[icount][3])) + ") Days With This Set of Clothes" ));
                for (int i = 0; i < (cases[icount][0]); i++)
                    for (int j = 0; j < (cases[icount][1]); j++)
                        for (int k = 0; k < (cases[icount][3]); k++)
                        {
                            System.out.println((i + 1) + " " + (j + 1) + " " + (k + 1));
                            outfitpanels[icount].add(new JLabel( " |" + ((i + 1) + " " + (j + 1) + " " + (k + 1)) + "| "));
                        }
            }
            else
            {
                System.out.println((cases[icount][3]) * (cases[icount][0]) * (cases[icount][1]));
                casepanels[icount].add ( new JLabel( " Lasted (" + ((cases[icount][3]) * (cases[icount][0]) * (cases[icount][1])) + ") Days With This Set of Clothes" ));
                for (int i = 0; i < (cases[icount][1]); i++)
                    for (int j = 0; j < (cases[icount][0]); j++)
                        for (int k = 0; k < (cases[icount][3]); k++)
                        {
                            System.out.println((j + 1) + " " + ((i + j + k) % (cases[icount][1]) + 1) + " " + (i + 1));
                            outfitpanels[icount].add(new JLabel( " |" + ((j + 1) + " " + ((i + j + k) % (cases[icount][1]) + 1) + " " + (i + 1)) + "| "  ));
                        }
            }
        }

        myFrame.setVisible(true);
        myFrame.revalidate();

    }
}
