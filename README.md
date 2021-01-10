# AdManager
AdMob &amp; Facebook Ads Autopilot

## Prerequisites

Add this in your root `build.gradle` file (**not** your module `build.gradle` file):

```gradle
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

## Dependency

Add this to your module's `build.gradle` file (make sure the version matches the JitPack badge above):

```gradle
dependencies {
	...
	implementation 'com.github.nademk:AdManager:1.0.0'
}
```

## Configuration

This step is important, in order to initialize Ad Networks you need to add the below code to your Application class:

```java
public class App extends AdManagerApp {
      ...
}

```

Also in `Manifest.xml`:

```xml
<application
      android:name=".App"
      ...
      ...
      ...
      ...  >
	
</application>

```

## Usage

For showing banner ads, you need to extend your activity class to `BannerAdActivity` class:

Example:
``` java
public class MainActivity extends BannerAdActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ...
        showAdmobBanner("", R.id.ad_layout);
    }
}
```

Declare Ad Layout in your `Activity.xml`:

``` xml
<LinearLayout
     android:id="@+id/ad_layout"
     android:layout_width="match_parent"
     android:layout_height="wrap_content"
     android:layout_centerHorizontal="true"
     android:layout_alignParentBottom="true"
     android:orientation="horizontal">
</LinearLayout>
```

Show AdMob Banner:

``` java
showAdmobBanner("ADMOB_BANNER_AD_ID_HERE", R.id.ad_layout);
```
Show AdMob Interstitial:

``` java
InterstitialAdUtility.showAdmobInterstitial(MainActivity.this, "ADMOB_INTERSTITIAL_AD_ID_HERE", 1);
```

Show Facebook Banner:

``` java
showFacebookBanner("FACEBOOK_BANNER_AD_ID_HERE", R.id.ad_layout);
```
Show Facebook Interstitial:

``` java
InterstitialAdUtility.showFbInterstitial(MainActivity.this, "FACEBOOK_INTERSTITIAL_AD_ID_HERE", 1);
```
