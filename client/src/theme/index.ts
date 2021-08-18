export const size = {
  largest: '75em', // 1200px
  large: '56.25em', // 900px
  medium: '37.5em', // 600px
  small: '31.25em', // 500px
  smallest: '25em', // 400px
};

const theme = {
  BACKGROUND_COLOR: '#ffffff',
  BLUE_COLOR: '#36f',
  GRAY_COLOR: '#666',
  GRAY_BOX: '#e1e2e3',
  BACKGROUND_GRADIENT: 'linear-gradient(270deg, #fc686f 0%, #ff924b 100%)',
  mq: {
    laptop: `@media only screen and (min-width: ${size.largest})`,
    tablet: `@media only screen and (min-width: ${size.large})`,
    mobile: `@media only screen and (min-width: ${size.small})`,
  },
};

export default theme;

export type ThemeType = typeof theme;
