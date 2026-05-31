/** @type {import('jest').Config} */
module.exports = {
  preset: 'ts-jest',
  testEnvironment: 'node',
  testMatch: ['**/src/**/*.test.ts'],
  transform: {
    '^.+\\.tsx?$': [
      'ts-jest',
      {
        tsconfig: {
          module: 'commonjs',
          esModuleInterop: true,
          skipLibCheck: true,
          allowJs: true,
        },
        useESM: false,
      },
    ],
    '^.+\\.js$': [
      'ts-jest',
      {
        tsconfig: {
          module: 'commonjs',
          esModuleInterop: true,
          allowJs: true,
        },
        useESM: false,
      },
    ],
  },
  transformIgnorePatterns: [
    'node_modules/(?!(@microsoft/kiota-))',
  ],
  moduleNameMapper: {
    '^(.*)\\.js$': '$1',
  },
  extensionsToTreatAsEsm: [],
};
