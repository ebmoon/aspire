PARSER = java -jar ~/antlr-4.13.1-complete.jar
VERSION = 0.0.1

jar:
	mvn -e compile assembly:single
	cp target/aspire-$(VERSION)-noarch.jar aspire-$(VERSION)-noarch.jar

clean-parser:
	rm src/main/java/aspire/compiler/parser/Spyro*

parser:
	cd src/main/antlr/spyro/compiler/parser && $(PARSER) Spyro.g4 -o ../../../../java/aspire/compiler/parser/ -visitor -no-listener