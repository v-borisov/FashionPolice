# FashionPolice
GCJ solution w/GUI visualization


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
