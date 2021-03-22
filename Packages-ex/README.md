This is a demo of creating your own library in java and using it wherever you desire \
 \
We create a Series class in this project (Packages-ex/src/com.mypackage/) \
and make it into a jar file that we will later use as an imported library in Packages-ex-implementation/src/com.
package_implementation/Main.java \
 \
So the static methods created in Series.java i.e. nSum(), factorial(), fibonacci() will be available in Packages-ex-implementation \
just by using ->import com.mypackage.Series;

Steps to create a jar file:
1. Open your Library project (Packages-ex in my case)
2. File (Alt + F) -> Project Structure
3. Artifacts (on the sidebar) -> + (add) button
4. JAR ->From modules with dependencies -> click OK
5. Build (Alt + B) -> Build Artifacts -> Build
6. You can now find the jar file in Packages-ex/out/artifacts/Packages_ex_jar/ directory

Steps to include your custom library in the implementation project
1. Open your implementation project (Packages-ex-implementation in my case)
1. File (Alt + F) -> Project Structure
2. Libraries -> + (add) button -> Java
3. Navigate to Packages-ex/out/artifacts/Packages_ex_jar/Packages-ex.jar
4. Click OK and your custom library will be imported
