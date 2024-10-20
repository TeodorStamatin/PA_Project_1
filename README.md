# Tema 1 Proiectarea Algoritmilor

## Servere

Am folosit "Scanner" si "PrintWriter" pentru citirea si scrierea in fisiere. Urmatorul pas a fost
sa citesc nr de servere, puterile de calcul si limitele de alimentare ale lor. Am folosit cautarea
binara pentru a gasi puterea de calcul maxima, astfel: am calculat minimul si maximul  limitelor
de  alimentare, valori intre care am facut cautarea cu o precizie de **10^-1 / 2**, la fel ca eroarea
radicalului facut in primul laborator. Dupa ce am calculat puterea pentru  media dintre extreme,
folosesc o variabila temporara pentru a stabili in ce jumatate voi continua cautarea. Aceasta
variabila temporara este putin mai mica decat decat valoarea de mijloc si functioneaza ca un fel de
**eroare**, iar daca puterea calculata pentru aceasta se dovedeste a fi mai mare decat puterea valorii
medii, cautarea va continua in partea din stanga, altfel, in partea dreapta; astfel de deplasam pe
graficul "functiei" spre punctul de maxim **( O(nlogn) )**. La fiecare pas compar puterea calculata cu
puterea maxima gasita pana la acel pas.

## Colorare

Am folosit "Scanner" si "PrintWriter" pentru citirea si scrierea in fisiere. Am citit numarul de
combinatii, dupa care le am citit rand pe rand. Daca sunt la prima placuta orizontala sau verticala,
aceasta va avea o valoare diferita fata de restul: 3 pentru V si 6 pentru H. Apoi verific mereu ce
fel de placuta este inainte de placuta pe care sunt si se definesc astfel **4 cazuri**:

1. _V V_, caz in care rezultatul se inmulteste cu 2;

2. _H H_, caz in care rezultatul se inmulteste cu 3;

Pentru aceste 2 cazuri am folosit **ridicarea la putere** in timp logaritmic, impartind totodata
la fiecare pas rezultatul cu **MOD**.

3. _V H_, caz in care rezultatul se inmulteste cu 2;

4. _H V_, caz in care rezultatul ramane la fel sau se inmulteste cu 1;

Pentru ultimele 2 cazuri, doar prima placuta difera ca valoare, asa ca dupa ce fac prima inmultire
schimb valoarea variabilei "prevPoz" unde stochez tipul placutei de dinainte pentru a coincide cu "currPoz"
si a putea face **ridicarea la putere in timp logaritmic** ce are complexitatea **O(logn)** folosind primele
2 cazuri. Complexitatea se ridica totusi la **O(nlogn)** deoarece se parcurg toate perechile de placute.

## Compresie

Am folosit "Scanner" si "PrintWriter" pentru citirea si scrierea in fisiere. Am utilizat algortimul
de **interclasare** pentru a forma un al 3 lea vector care sa contina elementele finale **( O(m+n) )**.
Am parcurs ambii vector, la fiecare pas verificand daca **suma elementelor** de dinaintea elementului
pe care ma aflu in vectorul **A** este egala cu **suma elementelor** de dinaintea elementului pe care
ma aflu in vectorul **B**. Daca sumele sunt **egale**, adaug suma respectiva la al 3 lea vector, suma
care va fi de fapt un element din **secventa finala**. Altfel, verific sumele din nou pentru a vedea in
care dintre cei 2 vectori trebuie sa incrementez indexul (in cel cu suma mai mica). In final,
**lungimea maxima** pe care o pot avea cele 2 siruri este chiar lungimea celui de al 3 lea vector creat.

## Criptat

Am folosit "Scanner" si "PrintWriter" pentru citirea si scrierea in fisiere. Am construit un
**vector de clase**, clasa continand cuvantul, lungimea sa, **frecventa** fiecarei litere precum
si **densitatea** fiecarei litere. Dupa ce am citit toate cuvintele, am calculat pentru fiecare
litera a alfabetlui **lungimea maxima a cuvantului** ce se poate forma avand acea litera **predominanta**:
am **sortat** cuvintele  la fiecare pas in functie de densitatea literei dorite ( O(nlogn) ), dupa
care am **concatenat** cuvintele in ordinea descrescatoare a densitatilor literei pana cand frecventa
acesteia din rezultat era mai mica decat jumatate din lungimea rezultatului. Dupa fiecare cuvant
aflat, il compar cu un rezultat final pentru a stoca lungimea maxima a cuvantului ce se poate forma
indiferent de litera.

## Oferta

Am folosit "Scanner" si "PrintWriter" pentru citirea si scrierea in fisiere. Dupa citirea pretului
produselor, am creat un vector pentru programarea dinamica, "dp" pentru a stoca **preturile minime**.
Avem **4 cazuri**: 

1. Daca avem un singur element, atunci pretul minim este pretul acelui produs.

2. Daca avem 2 elemente, pretul minim este suma pretului dintre cele 2 produse, din care se scade
jumatate din pretul celui mai mic.

3. Cand avem 3 elemente, pretul minim este cel mai mic numar dintre: suma preturilor ultimelor doua
produse fara oferte **(single)**, suma preturilor ultimelor trei produse cu reducerea pentru
gruparea ultimelor 2 produse **(twins)**, sau suma preturilor tuturor produselor cu reducerea
pentru gruparea a trei produse **(triplets)**, cand se scade cel mai ieftin element dintre cele 3.

4. Cand avem 4 sau mai multe produse, se realizeaza calcule asemanatoare ca la cazul 3, doar ca de
data aceasta folosim **sumele anterioare** deja stocate in vectorul dp.

Procesul se repeta pentru toate produsele, avand complexitatea **O(n)**, iar la final pretul minim va
fi chiar ultimul element.