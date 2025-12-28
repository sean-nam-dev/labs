import {Pressable, StyleSheet, Text} from "react-native";

type Props = {
    title: string
    disabled: boolean,
    onPress: () => void
}

export function RoundedButton({ title, disabled = true, onPress }: Props) {
    return (
        <Pressable
            onPress={ onPress }
            disabled={ disabled }
            style={({ pressed }) => [
                styles.button,
                pressed && !disabled && styles.pressed,
                disabled && styles.disabled
            ]}>
            <Text style={ styles.buttonText }>
                { title }
            </Text>
        </Pressable>
    )
}

const styles = StyleSheet.create({
    button: {
        width: '100%',
        backgroundColor: '#40524c',
        borderRadius: 8,
        alignItems: 'center',
        justifyContent: "center"
    },
    pressed: {
        opacity: 0.85
    },
    disabled: {
        opacity: 0.5
    },
    buttonText: {
        color: 'white',
        fontSize: 22,
        padding: 5
    }
})