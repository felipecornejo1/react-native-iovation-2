const TurboModule = require('./NativeTurboModule').default;

export function multiply(a: number, b: number): number {
  return TurboModule.multiply(a, b);
}
