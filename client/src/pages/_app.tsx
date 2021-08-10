import type { AppProps } from 'next/app';
import { ThemeProvider } from '@emotion/react';
import Head from 'next/head';

import { globalStyles } from '@theme/globalStyle';
import theme from '@theme/.';

//최초로 실행되며, 이곳에서 렌더링 하는 겂은 모든페이지에 영향
function MyApp({ Component, pageProps }: AppProps) {
  return (
    <ThemeProvider theme={theme}>
      <Head>
        <title>Nextjs App with TypeScript</title>
        <link rel="icon" href="/favicon.ico" />
      </Head>
      {globalStyles}
      <Component {...pageProps} />
    </ThemeProvider>
  );
}
export default MyApp;
