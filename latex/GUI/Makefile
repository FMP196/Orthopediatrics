SRC=$(wildcard *.png)
DST=$(SRC:.png=.pdf)

%.pdf:		%.png
		inkscape -f $< -A $@
				
dia2pdf:	$(DST)

