/**
 * 
 */
var MyJavaClass = Java.type('com.jeocloud.algorithms.jsengine.MyJavaClass');

var map = new java.util.HashMap();
map.put('foo', 'red');
map.put('bar', 'green');

var user = {username: "denghuizhi", password: "abcdefghijkl"} 
MyJavaClass.jsonToBean(JSON.stringify(user));
MyJavaClass.beanToJSON(user);


MyJavaClass.printType(map);

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


MyJavaClass.printObjectMirror(new Number(123));
MyJavaClass.printObjectMirror(new Date());
MyJavaClass.printObjectMirror(new RegExp());
MyJavaClass.printObjectMirror({
    foo: 'bar',
    bar: 'foo'
});

load('https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.1/moment.min.js');

var now = new moment();
print(now);
