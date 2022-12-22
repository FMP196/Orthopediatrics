SRC=$(wildcard *.jpg)
DST=$(SRC:.jpg=.png)

%.png:		%.jpg
		convert $< $@
				
dia2pdf:	$(DST)

