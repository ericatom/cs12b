#Makefile
#Erica Tom
#edtom
#pa2
#April 17 2016
#Makefile for Search.jaa

JAVASRC = Search.java
SOURCES = README Makefile $(JAVASRC)
MAINCLASS = Search
CLASSES = Search.class
JARFILE = Search
SUBMIT = submit cmps012b-pt.s16 pa2
CHECK = ls /afs/cats.ucsc.edu/class/cmps012b-pt.s16/pa2/edtom
all: $(JARFILE)
$(JARFILE): $(CLASSES)
        echo Main-class: $(MAINCLASS) > Manifest
        jar cvfm $(JARFILE) Manifest $(CLASSES)
        rm Manifest
        chmod +x $(JARFILE)
$(CLASSES): $(JAVASRC)
        javac -Xlint $(JAVASRC)
clean:
        rm $(CLASSES) $(JARFILE)
submit: $(SOURCES)
        $(SUBMIT) $(SOURCES)
check:
        $(CHECK)
