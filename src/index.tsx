const TurboModule = require('./NativeTurboModule').default;

export function multiply(a: number, b: number): Promise<number> {
  return TurboModule.multiply(a, b);
}

export function getBlackbox(): Promise<string> {
  return TurboModule.getBlackbox(1, 1);
}
