# Android SMS Reader Sample

This folder contains a minimal Kotlin example that demonstrates how to read SMS messages from specific banking shortcodes and store them in a Room database.

## Components

- **SMSReceiver**: A `BroadcastReceiver` that listens for incoming SMS messages. Messages originating from configured short codes are stored using the repository.
- **SmsMessageEntity**: Room entity representing an SMS message.
- **SmsDao**: DAO interface for accessing stored messages.
- **AppDatabase**: Singleton Room database.
- **SmsRepository**: Simple repository that filters messages by bank short codes and persists them.
- **MainActivity**: Example activity that requests SMS permissions and registers the receiver.

This sample only captures SMS messages. Parsing and classification, billing cycle handling, and UI dashboards need to be implemented as described in the project specification.
