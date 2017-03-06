#------------------------------------------------------------------------------
#Makefile
#Erica Tom
#edtom
#12B/12M
#April 7 2016
# A Makefile for ReverseArray
#------------------------------------------------------------------------------

JAVASRC = ReverseArray.java
SOURCES = README Makefile $(JAVASRC)
MAINCLASS = ReverseArray
CLASSES = ReverseArray.class
JARFILE = ReverseArray
SUBMIT = submit cmps012b-pt.s16 pa1
CHECK = ls  /afs/cats.ucsc.edu/class/cmps012b-pt.s16/pa1/edtom

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
