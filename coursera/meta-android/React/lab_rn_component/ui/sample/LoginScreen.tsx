import {StyleSheet, Text, TextInput, View} from "react-native";
import {LittleLemonHeader} from "./LittleLemonHeader.tsx";
import {LittleLemonFooter} from "./LittleLemonFooter.tsx";
import {useState} from "react";

export function LoginScreen() {
    const [email, onEmailChange] = useState('')
    const [password, onPasswordChange] = useState('')

    return (
        <View style={ styles.container }>
            <LittleLemonHeader />

            <View style={ styles.body }>
                <Text style={ styles.title }>
                    Welcome to Little Lemon
                </Text>
                <Text style={ styles.subtitle }>
                    Login to continue
                </Text>
                <TextInput
                    style={ styles.textInput }
                    value={ email }
                    onChangeText={ onEmailChange }
                    placeholder={ "email" }
                    keyboardType={'email-address'}
                />
                <TextInput
                    style={ styles.textInput }
                    value={ password }
                    onChangeText={ onPasswordChange }
                    placeholder={ "password" }
                    keyboardType={'default'}
                    secureTextEntry={true}
                />
            </View>

            <LittleLemonFooter />
        </View>
    )
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#333333'
    },
    body: {
        flexDirection: "column",
        padding: 20,
        flex: 1
    },
    title: {
        fontSize: 30,
        color: '#EDEFEE',
        textAlign: 'center',
        padding: 20
    },
    subtitle: {
        fontSize: 24,
        color: '#EDEFEE',
        textAlign: 'center',
        padding: 20
    },
    textInput: {
        backgroundColor: '#EDEFEE',
        margin: 10
    }
})