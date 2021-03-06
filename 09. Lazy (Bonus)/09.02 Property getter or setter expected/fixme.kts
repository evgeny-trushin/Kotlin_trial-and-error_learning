//error: missing 'setValue(Fixme.Home.Companion, KProperty<*>, Fixme.TimeOfOperation)'interface TimeOfOperation {
import kotlin.reflect.KProperty

interface TimeOfOperation {
    fun getTime():Int
}

enum class Home(var min:Int):TimeOfOperation {

    RELAX(59), CLEAN(58);
    override fun getTime()=min

    companion object: TimeOfOperation {
        var defaultValueByLazy: TimeOfOperation by Lazy {RELAX}
        var lazy lazyDefaultValue: TimeOfOperation {RELAX}

        override fun getTime()=defaultValueByLazy.getTime()
        operator fun Any.setValue(
                companion: Home.Companion,
                property: KProperty<*>,
                timeOfOperation: TimeOfOperation) {
            defaultValueByLazy = companion
            lazyDefaultValue = companion
        }
    }
}

fun showTimeByDefault(c: TimeOfOperation){
    println("Time to clean at ${c.javaClass.getSimpleName()}: ${c.getTime()} min ")
}

showTimeByDefault(Home)