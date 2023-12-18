# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile


-keep class com.alexon.eatme.domain.models.** {*;}
-keep class com.alexon.eatme.core.ResponseState.*
-keep class com.alexon.eatme.core.Errors.*


-keepattributes SourceFile,LineNumberTable
-keep public class * extends java.lang.Exception

-keepclassmembers class * implements java.io.Serializable {
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

-dontwarn android.media.Spatializer$OnSpatializerStateChangedListener
-dontwarn android.media.Spatializer

-keepnames class com.facebook.FacebookActivity
-keepnames class com.facebook.CustomTabActivity

-keep class com.facebook.login.Login

-keepclassmembers class * {
    void onAnimationEnd(...);
}

# OkHttp
-keepattributes Signature
-keepattributes *Annotation*
-keep class com.squareup.okhttp.** { *; }
-keep interface com.squareup.okhttp.** { *; }
-dontwarn com.squareup.okhttp.**


# Retrofit
-keep class com.google.gson.** { *; }
-keep public class com.google.gson.** {public private protected *;}
-keep class com.google.inject.** { *; }
-keep class org.apache.http.** { *; }
-keep class org.apache.james.mime4j.** { *; }
-keep class javax.inject.** { *; }
-keep class javax.xml.stream.** { *; }
-keep class retrofit.** { *; }
-keep class com.google.appengine.** { *; }
-keepattributes *Annotation*
-keepattributes Signature
-dontwarn com.squareup.okhttp.*
-dontwarn rx.**
-dontwarn javax.xml.stream.**
-dontwarn com.google.appengine.**
-dontwarn java.nio.file.**
-dontwarn org.codehaus.**
-dontwarn retrofit2.**
-dontwarn org.codehaus.mojo.**
-keep class retrofit2.** { *; }
-keepattributes Exceptions
-keepattributes RuntimeVisibleAnnotations
-keepattributes RuntimeInvisibleAnnotations
-keepattributes RuntimeVisibleParameterAnnotations
-keepattributes RuntimeInvisibleParameterAnnotations

-keepattributes EnclosingMethod
-keepclasseswithmembers class * {
    @retrofit2.http.* <methods>;
}
-keepclasseswithmembers interface * {
    @retrofit2.* <methods>;
}
-keepattributes Signature, InnerClasses

# Retain service method parameters when optimizing.
-keepclassmembers,allowshrinking,allowobfuscation interface * {
    @retrofit2.http.* <methods>;
}

# Ignore annotation used for build tooling.
-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement

# Ignore JSR 305 annotations for embedding nullability information.
-dontwarn javax.annotation.**

# Guarded by a NoClassDefFoundError try/catch and only used when on the classpath.
-dontwarn kotlin.Unit

# Top-level functions that can only be used by Kotlin.
-dontwarn retrofit2.-KotlinExtensions

###### From https://github.com/square/okhttp#r8--proguard:
# JSR 305 annotations are for embedding nullability information.
-dontwarn javax.annotation.**

# A resource is loaded with a relative path so the package of this class must be preserved.
-keepnames class okhttp3.internal.publicsuffix.PublicSuffixDatabase

# Animal Sniffer compileOnly dependency to ensure APIs are compatible with older versions of Java.
-dontwarn org.codehaus.mojo.animal_sniffer.*

# OkHttp platform used only on JVM and when Conscrypt dependency is available.
-dontwarn okhttp3.internal.platform.ConscryptPlatform
#Glide
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep class * extends com.bumptech.glide.module.AppGlideModule {
 <init>(...);
}
-keep public enum com.bumptech.glide.load.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}
-keep class com.bumptech.glide.load.data.ParcelFileDescriptorRewinder$InternalRewinder {
  *** rewind();
}



# Add any classes the interact with gson
# the following line is for illustration purposes
-keep class com.tekitsolutions.remindme.RestApi.ApiClient
-keep class com.tekitsolutions.remindme.Model.** { *; }

# Hide warnings about references to newer platforms in the library
-dontwarn android.support.v7.**
# don't process support library
-keep class android.support.v7.** { *; }
-keep interface android.support.v7.** { *; }

-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
# To support Enum type of class members
-keepclassmembers enum * { *; }

-keep class com.activeandroid.** { *; }
-keep class com.activeandroid.**.** { *; }
-keep class * extends com.activeandroid.Model
-keep class * extends com.activeandroid.serializer.TypeSerializer

#PayFort SDK
-keepattributes *Annotation*
-keepnames class * implements java.io.Serializable
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    !static !transient <fields>;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}


# Workaround for Kotlin Safe Args issue
-if public class ** implements androidx.navigation.NavArgs
-keepclassmembers public class <1> {
    public static ** Companion;
    ** fromBundle(android.os.Bundle);
}

-keepattributes SourceFile,LineNumberTable
-renamesourcefileattribute SourceFile


-keep class androidx.fragment.app.FragmentContainerView
-keepclassmembers class androidx.fragment.app.FragmentContainerView{
    public <methods>;
}

-dontwarn android.os.ServiceManager
-dontwarn com.bun.miitmdid.core.MdidSdkHelper
-dontwarn com.bun.miitmdid.interfaces.IIdentifierListener
-dontwarn com.bun.miitmdid.interfaces.IdSupplier
-dontwarn com.google.firebase.iid.FirebaseInstanceId
-dontwarn com.google.firebase.iid.InstanceIdResult
-dontwarn com.huawei.hms.ads.identifier.AdvertisingIdClient$Info
-dontwarn com.huawei.hms.ads.identifier.AdvertisingIdClient
-dontwarn com.tencent.android.tpush.otherpush.OtherPushClient


-dontwarn android.support.v7.**
-keep class android.support.v7.widget.** { *; }

#Navigation Component
-keepnames class androidx.navigation.fragment.NavHostFragment
-keep class * extends android.support.v4.app.Fragment{}
-keep class * extends androidx.fragment.app.Fragment{}

-keepnames class * extends android.os.Parcelable
-keepnames class * extends java.io.Serializable


-keep class com.google.gson.reflect.TypeToken
-keep class * extends com.google.gson.reflect.TypeToken
-keep public class * implements java.lang.reflect.Type

-keepclasseswithmembernames class * {
   native <methods>;
}

-keep class androidx.renderscript.** { *; }

-dontobfuscate

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile


-dontwarn kotlin.reflect.jvm.internal.**
-keep class kotlin.reflect.jvm.internal.** { *; }
-keep interface javax.annotation.Nullable

-keepattributes SourceFile,LineNumberTable,*Annotation*,EnclosingMethod,Signature,Exceptions,InnerClasses
-keep,allowobfuscation,allowshrinking class kotlin.coroutines.Continuation
-dontwarn okhttp3.**
-dontwarn okio.**
-dontwarn javax.annotation.**
-keepclasseswithmembers class * {
    @retrofit2.http.* <methods>;
}
-keep,allowobfuscation,allowshrinking class retrofit2.Response

-keep class kotlin.Metadata { *; }
-keep class kotlin.reflect.** { *; }

-keep,allowshrinking class io.github.alexispurslane.bloc.data.SinglePolyUnwrappedDeserializer { *; }
-keep,allowshrinking class io.github.alexispurslane.bloc.data.SinglePolyUnwrappedDeserializer$** { *; }
-keepclassmembers class io.github.alexispurslane.bloc.data.** {
  @com.fasterxml.jackson.annotation.JsonCreator *;
  @com.fasterxml.jackson.annotation.JsonProperty *;
  ** serialize*(...);
  ** deserialize*(...);
}

-keep class io.github.alexispurslane.bloc.data.network.models.** {
    @com.fasterxml.jackson.annotation.** *;
    *;
}
-keep class io.github.alexispurslane.bloc.data.network.models.RevoltWebSocketRequest$** {
    @com.fasterxml.jackson.annotation.** *;
    *;
}
-keep class io.github.alexispurslane.bloc.data.network.models.RevoltWebSocketResponse$** {
    @com.fasterxml.jackson.annotation.** *;
    *;
}
-keep class com.fasterxml.jackson.** {
  *;
}

-dontwarn com.fasterxml.jackson.databind.**

-keep class * implements java.io.Serializable
-keep interface com.fasterxml.jackson.** { *; }
-keep class com.fasterxml.** { *; }
-dontwarn com.fasterxml.jackson.databind.**
-keep @com.fasterxml.jackson.annotation.JsonIgnoreProperties class * { *; }
-keep class com.fasterxml.jackson.annotation.** {
  *;
}
-keep class androidx.datastore.*.** {*;}

