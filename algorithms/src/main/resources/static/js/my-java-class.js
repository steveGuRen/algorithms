/**
 * 
 */
var MyJavaClass = Java.type('com.jeocloud.algorithms.jsengine.MyJavaClass');

MyJavaClass.printType('Hello');
//class java.lang.String

MyJavaClass.printType(123);
//class java.lang.Integer

MyJavaClass.printType(12.34);
//class java.lang.Double

MyJavaClass.printType(true);
//class java.lang.Boolean

MyJavaClass.printType(new Number(123));
//class jdk.nashorn.internal.objects.NativeNumber
//class jdk.nashorn.api.scripting.ScriptObjectMirror

MyJavaClass.printType(new Date());
//class jdk.nashorn.internal.objects.NativeDate
//class jdk.nashorn.api.scripting.ScriptObjectMirror

MyJavaClass.printType(new RegExp());
//class jdk.nashorn.internal.objects.NativeRegExp
//class jdk.nashorn.api.scripting.ScriptObjectMirror

MyJavaClass.printType({foo: 'bar'});
//class jdk.nashorn.internal.scripts.J04
//class jdk.nashorn.api.scripting.ScriptObjectMirror