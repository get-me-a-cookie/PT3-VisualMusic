To compile using javac :

	$ find -name "*.java" > sources.txt
	$ javac -d bin -classpath ./lib/flanagan.jar;./lib/gluegen-java-src.zip;./lib/gluegen-rt.jar;./lib/gluegen-rt-natives-linux-amd64.jar;./lib/gluegen-rt-natives-linux-i586.jar;./lib/gluegen-rt-natives-macosx-universal.jar;./lib/gluegen-rt-natives-windows-amd64.jar;./lib/gluegen-rt-natives-windows-i586.jar;./lib/jogl-all.jar;./lib/jogl-all-natives-linux-amd64.jar;./lib/jogl-all-natives-linux-i586.jar;./lib/jogl-all-natives-macosx-universal.jar;./lib/jogl-all-natives-windows-amd64.jar;./lib/jogl-all-natives-windows-i586.jar;./lib/jogl-java-src.zip @sources.txt
	$ rm sources.txt

To run using java :
	
	$ java -classpath ./lib/flanagan.jar;./lib/gluegen-java-src.zip;./lib/gluegen-rt.jar;./lib/gluegen-rt-natives-linux-amd64.jar;./lib/gluegen-rt-natives-linux-i586.jar;./lib/gluegen-rt-natives-macosx-universal.jar;./lib/gluegen-rt-natives-windows-amd64.jar;./lib/gluegen-rt-natives-windows-i586.jar;./lib/jogl-all.jar;./lib/jogl-all-natives-linux-amd64.jar;./lib/jogl-all-natives-linux-i586.jar;./lib/jogl-all-natives-macosx-universal.jar;./lib/jogl-all-natives-windows-amd64.jar;./lib/jogl-all-natives-windows-i586.jar;./lib/jogl-java-src.zip;./bin App.Pricipale_VisualsMusic