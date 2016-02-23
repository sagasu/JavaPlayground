del classes\main\java\com\sagasu\Helper.class

REM this will not work
REM java -cp classes main.java.com.sagasu.Main

REM this will almost work - it will work if helper.jar was created in classes directory, so in it's structure it starts with main\java...
java -cp classes;lib\helper.jar main.java.com.sagasu.Main
