# JDBCABAP

A JDBC driver using SAP JCo to read data from any ABAP based system, ECC, S/4Hana, BW.
Supports single table reads, gathering metadata and procedure invocation (RFCs/BAPIs).

## Usage

Because SAP does not allow to redistribute JCo and has no longer include it in the Maven repository, the first step is to download SAP JCo from the SAP support portal and copy the jar file and the library file into the Java class path.
This JDBC driver is loaded via 

	Connection conn = DriverManager.getConnection(jdbcurl, abapuser, abappassword);

and the jdbcurl follows the pattern

	jdbc:abap://<host>:<systemno>:<client>[:<lang>][?<param>=<value>]

Note that `systemno` must be two digits and `client` three digits always.



## Build

Once the repository is cloned, the only manual step is to add the SAP JCo jar and library files into the `lib` folder of the project. The Maven POM points to the `${project.basedir}/lib/sapjco3.jar` file.
At execution time the jar file is picked up and it in turn reads the library file from the same directory.
