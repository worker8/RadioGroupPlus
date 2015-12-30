# RadioGroupPlus

This is a tweak to the original Android `RadioGroup.java` class. This is because the original RadioGroup is only able to do:

![](http://i.imgur.com/nsDmoZsm.png)


And it is **not** able to do this:

![](http://i.stack.imgur.com/kQ4hx.png)

*Note: this image is stolen shamelessly from this Stackoverflow post: [http://stackoverflow.com/questions/20456322/preparing-customized-radio-group-type-of-layout](http://stackoverflow.com/questions/20456322/preparing-customized-radio-group-type-of-layout)

With `RadioGroupPlus`, you can do this:

![](http://i.imgur.com/HvtQ598.gif)

Doc
-------
Everything should function the same as the original `RadioGroup`, so refer to this: [http://developer.android.com/reference/android/widget/RadioGroup.html](http://developer.android.com/reference/android/widget/RadioGroup.html)

Demo
-------
Refer to `app/` folder of this repo.

Usage
-------
Simple example:

```
   <worker8.com.github.radiogroupplus.RadioGroupPlus
        android:id="@+id/radio_group_plus"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical">
        <LinearLayout...>
           <ImageView...>
           <TextView...>
           <RadioButton...>
        </LinearLayout>
        <LinearLayout...>
           <ImageView...>
           <TextView...>
           <RadioButton...>
        </LinearLayout>
        <LinearLayout...>
           <ImageView...>
           <TextView...>
           <RadioButton...>
        </LinearLayout>
   </worker8.com.github.radiogroupplus.RadioGroupPlus>
```

Explanation: the 3 `RadioButton` shown in the code above will be linked together by `RadioGroupPlus` automatically.

---

If you want a even weirder layout, it will also work, for example:

    <worker8.com.github.radiogroupplus.RadioGroupPlus
        android:id="@+id/radio_group_plus"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical">
        <LinearLayout...>
           <ImageView...>
           <TextView...>
           <RadioButton...>
        </LinearLayout>
        <LinearLayout...>
           <ImageView...>
           <TextView...>
           <RadioButton...>
        </LinearLayout>
        <LinearLayout...>
          <RelativeLayout>
             <ImageView...>
             <TextView...>
             <RadioButton...>
          </RelativeLayout>
          <RelativeLayout>
             <ImageView...>
             <TextView...>
             <RadioButton...>
          </RelativeLayout>
        </LinearLayout>
   </worker8.com.github.radiogroupplus.RadioGroupPlus>

Now the 2 `RadioButton` under the `LinearLayout` and the 2 `RadioButton` inside the `RelativeLayout` will all be linked together.

In fact, there is no limitation to what the layout should look like, because `RadioGroupPlus` will just look for all the `RadioButton` in it's children and link them together.

How it works / Contribute
-------
You don't actually need to read this part unless you are interested or you want to contribute or fix this repo. I wrote a simple `TreeTraversel` to traverse all the children that will be added to `RadioGroupPlus`, a Pre-order traversal is used but there is no special reason of why because it doesn't really matter in this case. 

While traversing, the listener `mChildOnCheckedChangeListener` is added to the `RadioButton`, so when the `RadioButton` is clicked, `mChildOnCheckedChangeListener` will be called, and `CheckedStateTracker#onCheckedChanged` will be called to properly toggle the `RadioButton`s.

In short, look for `traverseTree()` in [](https://github.com/worker8/RadioGroupPlus/blob/master/radiogroupplus/src/main/java/worker8/com/github/radiogroupplus/RadioGroupPlus.java) if you want to make changes.


Download/Install
-------
Add this to **top** level `build.gradle`:

    allprojects {
        repositories {
            maven { url "https://jitpack.io" }
        }
    }

Add this under dependencies:

    compile 'com.github.worker8:RadioGroupPlus:v1.0.1'

If you run into conflict, use this instead:

    compile('com.github.worker8:RadioGroupPlus:v1.0.1') {
        transitive = false;
    }
    

The MIT License (MIT)
-------

    Copyright 2015 Tan Jun Rong

    Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
