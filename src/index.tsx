const TurboModule = require('./NativeTurboModule').default;

export function multiply(a: number, b: number): number {
  return TurboModule.multiply(a, b);
}

export function getBlackbox(): string {
  const blackbox = TurboModule.getBlackbox(1, 1);
  if (typeof blackbox === 'number') return '';
  return blackbox;
}
