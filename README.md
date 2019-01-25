
# @qudian_mobile/qd-react-native-u-i

## Getting started

`$ npm install @qudian_mobile/qd-react-native-u-i --save`

### Mostly automatic installation

`$ react-native link @qudian_mobile/qd-react-native-u-i`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `@qudian_mobile/qd-react-native-u-i` and add `QDReactNativeUI.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libQDReactNativeUI.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.qudian.ui.QDReactNativeUIPackage;` to the imports at the top of the file
  - Add `new QDReactNativeUIPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':@qudian_mobile/qd-react-native-u-i'
  	project(':@qudian_mobile/qd-react-native-u-i').projectDir = new File(rootProject.projectDir, 	'../node_modules/@qudian_mobile/qd-react-native-u-i/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':@qudian_mobile/qd-react-native-u-i')
  	```


## Usage
```javascript
import QDReactNativeUI from '@qudian_mobile/qd-react-native-u-i';

// TODO: What to do with the module?
QDReactNativeUI;
```
  