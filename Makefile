.PHONY: build clean 

build: Servere.class Colorare.class Compresie.class Criptat.class Oferta.class

Servere.class: Servere.java
	javac -d . $^

Colorare.class: Colorare.java
	javac -d . $^

Compresie.class: Compresie.java
	javac -d . $^
	
Criptat.class: Criptat.java
	javac -d . $^

Oferta.class: Oferta.java
	javac -d . $^

run-p1:
	java Servere
run-p2:
	java Colorare
run-p3:
	java Compresie
run-p4:
	java Criptat
run-p5:
	java Oferta

clean:
	rm -f *.class
	
