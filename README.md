
# @qudian_mobile/qd-react-native-u-i

## Getting started

`$ npm install @qudian_mobile/qd-react-native-ui --save`

### Mostly automatic installation

`$ react-native link @qudian_mobile/qd-react-native-ui`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `@qudian_mobile/qd-react-native-ui` and add `QDReactNativeUI.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libQDReactNativeUI.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainApplication.java`
  - Add `import com.qudian.ui.QDUIReactPackage;` to the imports at the top of the file
  - Add `new QDUIReactPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':@qudian_mobile/qd-react-native-ui'
  	project(':@qudian_mobile/qd-react-native-ui').projectDir = new File(rootProject.projectDir, 	'../node_modules/@qudian_mobile/qd-react-native-ui/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':@qudian_mobile/qd-react-native-ui')
  	```

## API
1. QDImage
2. ....
## Usage

### 1. QDImage
```
propTypes: {
	source: PropTypes.any,
	resizeMode: PropTypes.oneOf(['cover', 'contain', 'stretch', 'center']),
	...Image.propTypes, // 包含默认的View的属性
},
```

```javascript
import {QDImage} from '@qudian_mobile/qd-react-native-ui';
...
<QDImage source={{uri:'https://imgqcg01.qfq.me/cd/50/cd50f91376d4d10ad60e2fd900c88b56.png'}} style={{width:200,height:200}}/>
```
  