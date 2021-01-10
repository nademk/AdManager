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

Show AdMob Banner:

``` java
showAdmobBanner("", R.id.ad_layout);
```
Show AdMob Interstitial:

``` java
InterstitialAdUtility.showAdmobInterstitial(MainActivity.this, "YOUR_ADMOB_INTERSTITIAL_ID_HERE", 1);
```

Show Facebook Banner:

``` java
showFacebookBanner("", R.id.ad_layout);
```
Show Facebook Interstitial:

``` java
InterstitialAdUtility.showFbInterstitial(MainActivity.this, "YOUR_FACEBOOK_INTERSTITIAL_ID_HERE", 1);
```
