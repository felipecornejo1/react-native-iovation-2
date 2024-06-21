
#ifdef RCT_NEW_ARCH_ENABLED
#import "RNTurboModuleSpec.h"

@interface TurboModule : NSObject <NativeTurboModuleSpec>
#else
#import <React/RCTBridgeModule.h>

@interface TurboModule : NSObject <RCTBridgeModule>
#endif

@end
