# MSAppAPI
<h3>FAQ and common issues.</h3>
Missing deployment descriptor.

Usually caused by a missing WEB-INF folder. Check that in the folder "web" of the main directory, there is a WEB-INF folder. 
It doesn't matter if it's empty, just that it exists.

Missing dependencies.
src/dependendencies should contain all the necessary jar files required for the project to be built successfully. 
