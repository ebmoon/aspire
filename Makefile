PARSER = java -jar ~/antlr-4.13.1-complete.jar
VERSION = 0.0.1

jar:
	mvn -e compile assembly:single
	cp target/aspire-$(VERSION)-noarch.jar aspire-$(VERSION)-noarch.jar

clean-parser:
	rm src/main/java/aspire/compiler/parser/Spyro*

parser:
	cd src/main/antlr/spyro/compiler/parser && $(PARSER) Spyro.g4 -o ../../../../java/aspire/compiler/parser/ -visitor -no-listener

table1:
	python make_tables/make_table1.py

table2:
	python make_tables/make_table2.py

table3:
	python make_tables/make_table3.py