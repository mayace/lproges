
basedir		= .
srcdir		= $(basedir)/src
distdir 	= $(basedir)/es
libdir 		= $(basedir)/lib
cuplib 		= $(libdir)/java-cup-11a.jar
jflexlib	= $(libdir)/JFlex.jar

cup_file 	= $(srcdir)/es/parser.cup
jflex_file 	= $(srcdir)/es/scanner.jflex

cup: $(cup_file)
	java -jar $(cuplib) -parser Parser -symbols Sym $(cup_file)
	mv Sym.java $(distdir)
	mv Parser.java  $(distdir)

jflex: $(flex_file)
	java -jar $(jflexlib) $(jflex_file)
	mv $(srcdir)/es/Scanner.java $(distdir)

all: cup jflex
	echo "Compiled..."