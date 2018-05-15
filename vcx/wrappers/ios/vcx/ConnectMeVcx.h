//
//  init.h
//  vcx
//
//  Created by GuestUser on 4/30/18.
//  Copyright © 2018 GuestUser. All rights reserved.
//

#ifndef init_h
#define init_h
#import "libvcx.h"

extern void VcxWrapperCommonCallback(vcx_command_handle_t xcommand_handle,
                                     vcx_error_t err);

extern void VcxWrapperCommonHandleCallback(vcx_command_handle_t xcommand_handle,
                                           vcx_error_t err,
                                           vcx_command_handle_t pool_handle);

extern void VcxWrapperCommonStringCallback(vcx_command_handle_t xcommand_handle,
                                           vcx_error_t err,
                                           const char *const arg1);

extern void VcxWrapperCommonBoolCallback(vcx_command_handle_t xcommand_handle,
                                         vcx_error_t err,
                                         unsigned int arg1);

extern void VcxWrapperCommonStringStringCallback(vcx_command_handle_t xcommand_handle,
                                                 vcx_error_t err,
                                                 const char *const arg1,
                                                 const char *const arg2);

extern void VcxWrapperCommonStringOptStringCallback(vcx_command_handle_t xcommand_handle,
                                                    vcx_error_t err,
                                                    const char *const arg1,
                                                    const char *const arg2);

extern void VcxWrapperCommonDataCallback(vcx_command_handle_t xcommand_handle,
                                         vcx_error_t err,
                                         const uint8_t *const arg1,
                                         uint32_t arg2);

extern void VcxWrapperCommonStringStringStringCallback(vcx_command_handle_t xcommand_handle,
                                                       vcx_error_t err,
                                                       const char *const arg1,
                                                       const char *const arg2,
                                                       const char *const arg3);

extern void VcxWrapperCommonStringDataCallback(vcx_command_handle_t xcommand_handle,
                                               vcx_error_t err,
                                               const char *const arg1,
                                               const uint8_t *const arg2,
                                               uint32_t arg3);

extern void VcxWrapperCommonNumberCallback(vcx_command_handle_t xcommand_handle,
                                           vcx_error_t err,
                                           int32_t handle);

extern void VcxWrapperCommonStringOptStringOptStringCallback(vcx_command_handle_t xcommand_handle,
                                                             vcx_error_t err,
                                                             const char *const arg1,
                                                             const char *const arg2,
                                                             const char *const arg3);

void VcxWrapperCommonStringStringLongCallback(vcx_command_handle_t xcommand_handle,
                                              vcx_error_t err,
                                              const char *arg1,
                                              const char *arg2,
                                              unsigned long long arg3);

@interface ConnectMeVcx : NSObject

- (void)init:(NSString *)config
    completion:(void (^)(NSError *error))completion;

- (void)createOneTimeInfo:(NSString *)config
               completion:(void (^)(NSError *error, NSString *config))completion;

- (void)createConnectionWithInvite:(NSString *)invitationId
                     inviteDetails:(NSString *)inviteDetails
                        completion:(void (^)(NSError *error, NSString *credentialHandle))completion;

- (void)connectionHandle:(VcxHandle *)connectionHandle
          connectionType:(NSString *)connectionType
              completion:(void (^)(NSError *error, NSString *inviteDetails))completion;

- (void)updatePushToken:(NSString *)config
             completion:(void (^)(NSError *error))completion;

- (void)getCredential:(NSInteger *)credentailHandle
           completion:(void (^)(NSError *error, NSString *credential))completion;

- (void)generateCredentail:(NSString *)credentialOffer
                 remoteDid:(NSString *)sourceId
                completion:(void (^)(NSError *error, NSInteger *credentailHandle))completion;

- (void)sendCredentialRequest:(NSInteger *)credentailHandle
             connectionHandle:(VcxHandle *)connectionHandle
                   completion:(void (^)(NSError *error))completion;
- (void)getCredentialState:(NSInteger *)credentailHandle
                completion:(void (^)(NSError *error, NSInteger *state))completion;

@end

#endif /* init_h */