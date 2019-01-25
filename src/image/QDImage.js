import { PropTypes } from 'prop-types';
import { requireNativeComponent, View, Image, Platform } from 'react-native';

const iface = {
  name: 'QDImageView',
  propTypes: {
    source: PropTypes.any,
    resizeMode: PropTypes.oneOf(['cover', 'contain', 'stretch', 'center']),
    ...Image.propTypes, // 包含默认的View的属性
  },
};
export default (Platform.OS === 'android') ? requireNativeComponent('QDImageView', iface) : Image;