import {createNativeStackNavigator} from "@react-navigation/native-stack";
import {NavigationContainer} from "@react-navigation/native";
import {WelcomeScreen} from "./ui/screen/WelcomeScreen.tsx";
import {SubscribeScreen} from "./ui/screen/SubscribeScreen.tsx";

const Stack = createNativeStackNavigator()

function App() {
    return (
        <NavigationContainer>
            <Stack.Navigator initialRouteName="Welcome">
                <Stack.Screen
                    options={{ title: 'Welcome' }}
                    name="Welcome"
                    component={WelcomeScreen}
                />
                <Stack.Screen
                    options={{ title: 'Subscribe' }}
                    name="Subscribe"
                    component={SubscribeScreen}
                />
            </Stack.Navigator>
        </NavigationContainer>
    );
}

export default App;
