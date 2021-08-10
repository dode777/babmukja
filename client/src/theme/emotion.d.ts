import '@emotion/react';

declare module '@emotion/react' {
  export interface Theme {
    BACKGROUND_COLOR: string;
    BLUE_COLOR: string;
    GRAY_COLOR: string;
    GRAY_BOX: string;
    mq: {
      laptop: string;
      tablet: string;
      mobile: string;
    };
  }
}
